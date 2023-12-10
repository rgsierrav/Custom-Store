# Define the main class
MAIN = Main

# Compilation options
JAVAC = javac
JAVAFLAGS = -d .

# List all your source files here
SOURCES = Main.java Admin.java Customer.java Inventory.java Product.java ShoppingCart.java User.java

# Generate corresponding .class file names
CLASSES := $(SOURCES:.java=.class)

# Define targets
.PHONY: all clean run

# Default target
all: $(MAIN).class

# Compile .java files into .class files
$(MAIN).class: $(SOURCES)
	$(JAVAC) $(JAVAFLAGS) $^

# Create a JAR file for your project
project.jar: $(MAIN).class $(CLASSES)
	jar cvfe project.jar $(MAIN) $(MAIN).class $(CLASSES)

# Run the program
run: project.jar
	java -jar project.jar

# Clean the project (remove .class files and JAR)
clean:
	rm -f *.class project.jar

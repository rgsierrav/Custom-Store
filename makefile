# Define the compiler
JAVAC=javac

# Define the main class
MAIN=Main

# Define Java source files
SRC = Main.java \
      User.java \
      Admin.java \
      Customer.java \
      BobaProduct.java \
      BobaInventory.java \
      BobaShop.java \
      FileManager.java

# Define Java .class files
CLS = $(SRC:.java=.class)

# Default target
all: $(CLS)

# Rule for compiling
%.class : %.java
	$(JAVAC) $<

# Target to run the program
run: all
	java $(MAIN)

# Target to clean the directory
clean:
	rm -f *.class

# Phony targets
.PHONY: all run clean

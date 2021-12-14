#javac -d "target/classes" @sources.txt
help:
	@echo ""
	@echo "usage: make COMMAND"
	@echo ""
	@echo "Quick-start Commands:"
	@echo " compile                     Compile to start .class"
	@echo " start                       Start program"

compile:
	@javac -d target/classes @sources.txt

start:
	@java -cp target/classes Main
	
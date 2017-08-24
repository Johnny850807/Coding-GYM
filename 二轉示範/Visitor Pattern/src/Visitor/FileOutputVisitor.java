package Visitor;

import Builder.FileBuilder;

public abstract class FileOutputVisitor implements Visitor{
	protected FileBuilder builder;

	public FileOutputVisitor(FileBuilder builder) {
		this.builder = builder;
	}
	
	
	
}

package com.medium.frederik.di.foo;

import lombok.Value;

@Value
class Foo {
	
	public final String id;
	public final String bar;
	
	public Foo(String id, String bar) {
		this.id = id;
		this.bar = bar;
	}
}

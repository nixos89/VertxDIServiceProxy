package com.medium.frederik.di.foo;

import lombok.NoArgsConstructor;
import lombok.Value;

//@Value
//@NoArgsConstructor(force = true)
class Foo {

	public String id;
	public String bar;

	public Foo(String id, String bar) {
		this.id = id;
		this.bar = bar;
	}

	public Foo() {

	}

	public String getId() {
		return id;
	}

	public String getBar() {
		return bar;
	}

	@Override
	public String toString() {
		return "Foo [id=" + id + ", bar=" + bar + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bar == null) ? 0 : bar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foo other = (Foo) obj;
		if (bar == null) {
			if (other.bar != null)
				return false;
		} else if (!bar.equals(other.bar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

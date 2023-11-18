package com.yogo.spring6recipes.models.sequence;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Sequence {
	private final AtomicInteger counter = new AtomicInteger(0);
	private String prefix;
	private String suffix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String nextValue() {
		return Optional.ofNullable(prefix).orElse("") + counter.getAndIncrement()
				+ Optional.ofNullable(suffix).orElse("");
	}

}

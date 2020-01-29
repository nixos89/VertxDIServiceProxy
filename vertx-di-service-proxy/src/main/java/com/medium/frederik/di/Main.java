package com.medium.frederik.di;

import io.vertx.core.Launcher;

public class Main {

	public static void main(String[] args) {
		Launcher.executeCommand("run", LauncherVerticle.class.getName());
	}
		
}

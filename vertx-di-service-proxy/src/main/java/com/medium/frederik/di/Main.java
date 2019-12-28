package com.medium.frederik.di;

import com.medium.frederik.di.foo.FooVerticle;

import io.vertx.core.Launcher;
import io.vertx.core.Promise;
import io.vertx.reactivex.core.AbstractVerticle;

public class Main {

	public static void main(String[] args) {
		Launcher.executeCommand("run", LauncherVerticle.class.getName());
	}
	
	public static class LauncherVerticle extends AbstractVerticle {

		@Override
		public void start(Promise<Void> promise) throws Exception {
			vertx.rxDeployVerticle(FooVerticle.class.getName())
				.toCompletable()
				.andThen(vertx.rxDeployVerticle(MainVerticle.class.getName()))
				.toCompletable()
				.subscribe(promise::complete, promise::fail);
		}
		
	}
	
}

package com.medium.frederik.di;

import java.util.UUID;

//import com.medium.frederik.di.foo.reactivex.FooRepository; // TODO: make it work -> generate IT (somehow) !!!

import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

	private com.medium.frederik.di.foo.FooRepository fooRepository;

	@Override
	public void init(Vertx vertx, Context context) {
		super.init(vertx, context);
//		fooRepository = new Foo
		
	}

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		JsonObject fooData = new JsonObject()
				.put("id", UUID.randomUUID().toString())
				.put("bar", "foobar");
		
		/* TODO - finish this method code BUT 1st RxJava2 implementation code for FooRepository (CLASS) must be generated !!! */
//		fooRepository.rxSave(fooData);
	}

	
	
}

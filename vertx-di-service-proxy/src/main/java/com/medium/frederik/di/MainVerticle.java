package com.medium.frederik.di;

import java.util.UUID;

import com.medium.frederik.di.foo.FooVerticle;
import com.medium.frederik.di.foo.reactivex.FooRepository;

import io.reactivex.Single;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.serviceproxy.ServiceProxyBuilder;

public class MainVerticle extends AbstractVerticle {

	private FooRepository fooRepository;

	@Override
	public void init(Vertx vertx, Context context) {
		super.init(vertx, context);
		fooRepository = new FooRepository(new ServiceProxyBuilder(vertx)
				.setAddress(FooVerticle.FOO_SERVICE_ADDRESS)
				.build(com.medium.frederik.di.foo.FooRepository.class)
				);		
	}

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		JsonObject fooData = new JsonObject()
				.put("id", UUID.randomUUID().toString())
				.put("bar", "foobar");
		
		fooRepository.rxSave(fooData)
			.doOnSuccess(foo -> System.out.println("Saved: " + foo))
			.map(foo -> foo.getString("id"))
			.flatMap(fooRepository::rxFindById)
			.doOnSuccess(foo -> System.out.println("Found: " + foo))
			.map(storedFoo -> storedFoo.getString("bar"))
			.filter(bar -> bar.equals("foobar"))
			.switchIfEmpty(Single.error(new IllegalStateException("Expecting input bar value.")))
			.toCompletable()
			.doOnComplete(() -> System.out.println("Saved and found foo with bar=foobar successfully."))
			.subscribe(startFuture::complete, startFuture::fail);			
	}

	
	
}

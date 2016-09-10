package pl.training.githubbrowser.model;


import android.app.DownloadManager;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fist on 2016-09-10.
 */
public interface GitHub {

	@GET("users/{username}/repos")
	Observable<List<Repository>> publicRepositories(@Path("username") String user);

	@GET
	Observable<User> userFromUrl(@Url String userUrl);

	class Factory {

		public static GitHub create() {
			OkHttpClient okHttpClient = new OkHttpClient.Builder()
					.addInterceptor(new Interceptor() {
						@Override
						public Response intercept(Chain chain) throws IOException {
							Request request = chain.request().newBuilder()
									.addHeader("Authorization", "token 0d37f569452cfa06d9faa571d5b804928379816f")
									.build();
							return chain.proceed(request);
						}
					}).build();


			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("https://api.github.com")
					.client(okHttpClient)
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
					.build();
			return retrofit.create(GitHub.class);
		}
	}
}


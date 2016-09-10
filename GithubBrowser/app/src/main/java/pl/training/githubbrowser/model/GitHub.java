package pl.training.githubbrowser.model;


import java.util.List;

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
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("https://api.github.com")
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
					.build();
			return retrofit.create(GitHub.class);
		}
	}
}


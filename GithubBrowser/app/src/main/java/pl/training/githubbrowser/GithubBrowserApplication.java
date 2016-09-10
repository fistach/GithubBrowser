package pl.training.githubbrowser;

import android.app.Application;



import android.app.Application;
import android.content.Context;

import pl.training.githubbrowser.model.GitHub;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by fist on 2016-09-10.
 */
public class GithubBrowserApplication extends Application {

	private GitHub github = GitHub.Factory.create();
	private Scheduler defaultScheduler = Schedulers.io();

	public static GithubBrowserApplication get(Context context) {
		return (GithubBrowserApplication) context.getApplicationContext();
	}

	public GitHub getGithub() {
		return github;
	}

	public Scheduler getDefaultScheduler() {
		return defaultScheduler;
	}
}

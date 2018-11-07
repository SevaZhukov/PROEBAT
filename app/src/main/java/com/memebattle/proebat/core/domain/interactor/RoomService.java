package com.memebattle.proebat.core.domain.interactor;

import android.util.Log;

import com.memebattle.proebat.App;
import com.memebattle.proebat.core.domain.model.Miss;
import com.memebattle.proebat.core.data.MissDAO;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RoomService {

    private static final String TAG = RoomService.class.getSimpleName();
    private static RoomService instance;
    private MissDAO missDAO;


    private RoomService() {
        missDAO = App.getInstance().getMissDatabase().missDAO();
    }

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    public void createMiss(final Miss miss) {
        Completable.fromAction(() -> missDAO.createMiss(miss))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Log.i(TAG, "Miss is created in db" + miss.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "Error to create in db " + miss.toString());
                    }
                });
    }

    public void getMiss(GetDataCallback<Miss> getDataCallback) {
        Single.fromCallable(() -> missDAO.getLast())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Miss>>() {

                    @Override
                    public void onSuccess(List<Miss> miss) {
                        if (miss.size() != 0)
                            getDataCallback.onSuccess(miss.get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        getDataCallback.onFailure(e);
                    }
                });
    }


    public void dropDatabase() {
        Completable.fromAction(() -> missDAO.dropDatabase())
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void getSumOfMiss(GetDataCallback<Long> getDataCallback) {
        Single.fromCallable(() -> missDAO.getSumOfMiss())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Long>() {
                    @Override
                    public void onSuccess(Long result) {
                        getDataCallback.onSuccess(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getDataCallback.onFailure(e);
                        Log.i(TAG, "Error getting sum of miss ");
                    }
                });
    }

    public void getSumOfMiss(GetDataCallback<Long> getDataCallback, long beginDate, long endDate) {
        Single.fromCallable(() -> missDAO.getSumOfMiss(beginDate, endDate))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Long>() {
                    @Override
                    public void onSuccess(Long result) {
                        getDataCallback.onSuccess(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getDataCallback.onFailure(e);
                        Log.i(TAG, "Error getting sum of miss ");
                    }
                });
    }


    public interface GetDataCallback<T> {
        void onSuccess(T result);

        void onFailure(Throwable throwable);
    }
}


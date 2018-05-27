package com.nanc.chids.testrx;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestRxReduce {
    static class PrintSubscriber extends Subscriber {
        private final String name;

        public PrintSubscriber(String name) {
            this.name = name;
        }

        @Override
        public void onCompleted() {
            System.out.println(name + ": Completed");
        }

        @Override
        public void onError(Throwable e) {
            System.out.println(name + ": Error: " + e);
        }

        @Override
        public void onNext(Object v) {
            System.out.println(name + ": " + v);
        }
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Data {
        private Integer type;
        private String name;
        private String name1;
    }

    public static void main(String[] args) throws Exception{
        Data data1 = new Data(1, "haoshijing", "haojinkun");
        Data data2 = new Data(1, "haoshijing1", "haojinkun1");
        Data data3 = new Data(2, "haoshijing333", "haojinkun33");

        Observable.from(Lists.newArrayList(data1, data2, data3)).toMultimap(new Func1<Data, Integer>() {
            @Override
            public Integer call(Data data) {
                return data.getType();
            }
        }).subscribe(new Action1<Map<Integer, Collection<Data>>>() {
            @Override
            public void call(Map<Integer, Collection<Data>> integerCollectionMap) {
                System.out.println("integerCollectionMap = [" + integerCollectionMap + "]");
            }
        });

        Observable.from(Lists.newArrayList(data1, data2, data3)).map(new Func1<Data, Integer>() {
            @Override
            public Integer call(Data data) {
                return data.toString().length();
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("throwable = [" + throwable + "]");
            }

            @Override
            public void onNext(Integer data) {
                System.out.println("data = [" + data + "],time is = " + System.currentTimeMillis());
            }

        });

        System.in.read();
    }
}

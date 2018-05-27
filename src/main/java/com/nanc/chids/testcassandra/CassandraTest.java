package com.nanc.chids.testcassandra;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.Insert;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import io.netty.util.concurrent.DefaultThreadFactory;

import javax.annotation.Nullable;

public class CassandraTest {
    static String[] CONTACT_POINTS = {"39.104.52.84"};
    static int PORT = 8042;

    public static void main(String[] args) {

        Cluster cluster = null;
        try {
            // The Cluster object is the main entry point of the driver.
            // It holds the known state of the actual Cassandra cluster (notably the Metadata).
            // This class is thread-safe, you should create a single instance (per target Cassandra cluster), and share
            // it throughout your application.
            SocketOptions socketOptions = new SocketOptions();
            socketOptions.setConnectTimeoutMillis(2000);
            socketOptions.setReadTimeoutMillis(2000);
            NettyOptions nettyOptions = new ExtNettyOptions();

            nettyOptions.eventLoopGroup(new DefaultThreadFactory("MyThread"));

            cluster = Cluster.builder().withSocketOptions(socketOptions).withNettyOptions(nettyOptions)
                    .addContactPoints(CONTACT_POINTS).withPort(PORT)
                    .build();

            // The Session is what you use to execute queries. Likewise, it is thread-safe and should be reused.
            ListenableFuture<Session> sessionListenableFuture = cluster.connectAsync("member");
            Futures.addCallback(sessionListenableFuture, new FutureCallback<Session>() {
                @Override
                public void onSuccess(@Nullable Session session) {
                    ResultSetFuture resultSetFuture =   session.executeAsync(" insert into student(id,username,sex) values" + "(1,'haojinkun','f')");
                    Futures.addCallback(resultSetFuture, new FutureCallback<ResultSet>() {
                        @Override
                        public void onSuccess(@Nullable ResultSet result) {
                            ResultSetFuture future1 =   session.executeAsync(" select username,sex from student where id = 1 ");
                            Futures.addCallback(future1, new FutureCallback<ResultSet>() {
                                @Override
                                public void onSuccess(@Nullable ResultSet result) {
                                    System.out.println("result = [" + result.one().getString("username") + "]");
                                }

                                @Override
                                public void onFailure(Throwable t) {
                                    System.out.println("t = [" + t + "]");
                                }
                            },MoreExecutors.directExecutor());
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            System.out.println("t = [" + t + "]");
                        }
                    },MoreExecutors.directExecutor());
                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.println("t3 = [" + t + "]");
                }
            },MoreExecutors.directExecutor());
            //createSchema(session);


        } finally {
            // Close the cluster after we’re done with it. This will also close any session that was created from this
            // cluster.
            // This step is important because it frees underlying resources (TCP connections, thread pools...). In a
            // real application, you would typically do this at shutdown (for example, when undeploying your webapp).
            if (cluster != null)
                cluster.close();
        }
    }

    private static void createSchema(Session session) {

       Futures.addCallback(session.executeAsync("CREATE TABLE IF NOT EXISTS student(" +
               "id int, username text, " +
               "sex text, " +
               "videoid int, title text, " +
               "PRIMARY KEY (id)" +
               ")"), new FutureCallback<ResultSet>() {
           @Override
           public void onSuccess(@Nullable ResultSet result) {

           }

           @Override
           public void onFailure(Throwable t) {
               System.out.println("t1 = [" + t + "]");
           }
       });
    }

}

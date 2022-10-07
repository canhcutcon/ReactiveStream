package dao.subscriber;

import org.bson.Document;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DocumentSubcrise implements Subscriber<Document> {
    Subscription subscription;
    List<Document> docs;
    CountDownLatch latch;

    public DocumentSubcrise() {
        docs = new ArrayList<>();
        latch = new CountDownLatch(1);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Document document) {
        docs.add(document);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
    @Override
    public void onComplete() {
        latch.countDown();
    }

    public List<Document> getDocs(){
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return docs;
    }
}

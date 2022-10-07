package dao.subscriber;

import com.mongodb.client.model.Filters;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import entity.Staff;
import org.bson.Document;
import org.reactivestreams.Publisher;
import utils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    MongoCollection<Document> staffCol;

    public StaffDao(MongoClient mongoClient, String dcName) {
        staffCol = mongoClient.getDatabase(dcName).getCollection("staffs");
    }

    public Staff getStaffById(long id){
        Publisher<Document> publisher = staffCol.find(Filters.eq("_id", id)).first();

        DocumentSubcrise subcrise= new DocumentSubcrise();
        publisher.subscribe(subcrise);

        List<Staff> staff = new ArrayList<>();

        subcrise.getDocs().forEach(e -> staff.add(Mapper.tranferDocumentToStaff(e)));
        return staff.size() > 0 ? staff.get(0) : null;
    }
}

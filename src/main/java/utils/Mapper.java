package utils;

import entity.Phone;
import entity.Staff;
import org.bson.Document;

public class Mapper {
    public static Document tranferStaffToDocument(Staff staff){
        Document phone = new Document("type", staff.getPhone().getType()).append("number", staff.getPhone().getNumber());
        return new Document(new Document("_id", staff.getStaffId())
                                 .append("first_name", staff.getFirstName()))
                                 .append("last_name", staff.getLastName())
                                 .append("phone",phone)
                                 .append("email", staff.getEmail())
                                 .append("manager_id", staff.getStaff().getStaffId());
    }

    public static Staff tranferDocumentToStaff(Document document)
    {
        Document phone = (Document) document.get("phone");
        return new Staff(document.getLong("_id"),
                         document.getString("first_name"),
                         document.getString("last_name"),
                         document.getString("email"),
                         new Phone(phone.getString("number"), phone.getString("type")),
                         new Staff(document.getLong("manager_id")));
    }
}

package databases;

import classes.Record;
import classes.User;
import exceptions.NotBorrowedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordShelf {
    private List<Record> recodList = new ArrayList<>();
    private static RecordShelf instance = new RecordShelf();

    public static RecordShelf getInstance() {
        return instance;
    }

    public boolean contains(User user, String ISBN) {
        for (Record record : recodList) {
            if (record.is(user, ISBN)) {
                return true;
            }
        }
        return false;
    }

    public void putRecord(User user, String ISBN) {
        Record record = new Record(user.getId(), ISBN);
        recodList.add(record);
    }

    public void remove(User user, String isbn) throws NotBorrowedException {
        int index = -1;
        for (int i = 0; i < recodList.size(); i++) {
            Record record = recodList.get(i);
            if (record.is(user, isbn)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NotBorrowedException();
        }
        recodList.remove(index);
    }


    public void remove1(User user, String isbn) throws NotBorrowedException {
        Iterator<Record> iterator = recodList.iterator();
        while (iterator.hasNext()) {
            Record s = iterator.next();
            if (s.is(user, isbn)) {
                iterator.remove();
                return;
            }
        }
        throw new NotBorrowedException();
    }

    public List<Record> queryRecords(Where<Record> where) {
        List<Record> ret = new ArrayList<>();
        for (Record record : recodList) {
            if (where.test(record)) {
                ret.add(record);
            }

        }
        return ret;
    }
}

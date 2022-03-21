import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (Resume value : storage) {
            if (value != null && value.uuid == uuid) {
                resume = value;
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        int indexOfElement = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid == uuid) {
               indexOfElement = i;
               break;
            }
        }
        for (int i = indexOfElement; i < storage.length-1; i++){
            storage[i] = storage[i+1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) count++;
        }

        Resume[] testStorage = new Resume[count];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                testStorage[i] = storage[i];
            }
        }
        return testStorage;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) count++;
        }
        return count;
    }
}
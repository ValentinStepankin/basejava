/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int indexOfElement = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
               indexOfElement = i;
               break;
            }
        }
        for (int i = indexOfElement; i < size; i++){
            storage[i] = storage[i+1];
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    
    Resume[] getAll() {
        Resume[] testStorage = new Resume[size];
        for (int i = 0; i < size; i++) {
            testStorage[i] = storage[i];
        }
        return testStorage;
    }

    int size() {
        return size;
    }
}
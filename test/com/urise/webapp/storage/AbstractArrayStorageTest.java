package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    public Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.update(storage.get("uuid1"));
    }

    @Test
    public void getAll() throws Exception {
        storage.getAll();
    }

    @Test
    public void save(){
        if (storage.size()<STORAGE_LIMIT) storage.save(new Resume("uuid4"));
        else throw new StorageException("Storage overflow", "uuid");
    }

    @Test
    public void delete() throws Exception {
        storage.delete("uuid1");
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist(){
        storage.delete("dummy");
    }

    @Test
    public void get(){
        storage.get("uuid1");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist(){
        storage.get("dummy");
    }
}
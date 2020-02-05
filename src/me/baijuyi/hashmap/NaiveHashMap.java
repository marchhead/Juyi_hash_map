package me.baijuyi.hashmap;

import java.util.LinkedList;

public class NaiveHashMap {

    private LinkedList[] buckets;
    private int bucketsLength;
    private int size = 0;

    public NaiveHashMap(int bucketsLength) {
        // Initialize data and bucketLength
        this.bucketsLength = bucketsLength;
        buckets = new LinkedList[bucketsLength];
        for (int i = 0;i<bucketsLength;i++) {
            buckets[i] = new LinkedList<Vampire>();
        }
    }

    public void put(Vampire v) {
        int number = hashFun(v.getvId());
        LinkedList<Vampire> bucket = buckets[number];
        Vampire vInBucket = getFromBucket(v.getvId(), bucket);
        if (vInBucket == null) {
            bucket.add(v);
            this.size += 1;
        } else {
            vInBucket.setName(v.getName());
            vInBucket.setGender(v.getGender());
            vInBucket.setAge(v.getAge());
            vInBucket.setPower(v.getPower());
            vInBucket.setDesire(v.getDesire());
            vInBucket.setFaceScore(v.getFaceScore());
        }

    }

    public Vampire get(int vId) {
        int number = hashFun(vId);
        LinkedList<Vampire> bucket = buckets[number];
        return getFromBucket(vId,bucket);
    }

    public void reomove(int vId) {
        int number = hashFun(vId);
        LinkedList<Vampire> bucket = buckets[number];
        Vampire v = getFromBucket(vId,bucket);
        if (v==null) {
            System.out.println("The id " + vId + " doesn't exist!");
        } else {
            bucket.remove(v);
            this.size -= 1;
        }

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i=0; i< buckets.length;i++) {
            s += "The "+ i +"th bucket is " + buckets[i].toString()+"\n";
        }
        return s;
    }

    private int hashFun(int vId) {
        return vId % bucketsLength;
    }

    private Vampire getFromBucket(int vId, LinkedList<Vampire> bucket) {
        for (Vampire v:bucket) {
            if (vId == v.getvId()) {
                return v;
            }
        }
        return null;
    }
}

// The entity needs to be stored into NaiveHashMap
class Vampire {
    private int vId;
    private String name;
    private char gender;
    private long age;
    private long power;
    private long desire;
    private long faceScore;

    public Vampire(int vId, String name, char gender, long age, long power, long desire, long faceScore) {
        this.vId = vId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.power = power;
        this.desire = desire;
        this.faceScore = faceScore;
    }

    public int getvId() {
        return vId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public long getDesire() {
        return desire;
    }

    public void setDesire(long desire) {
        this.desire = desire;
    }

    public long getFaceScore() {
        return faceScore;
    }

    public void setFaceScore(long faceScore) {
        this.faceScore = faceScore;
    }

    @Override
    public String toString() {
        return "Vampire{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", power=" + power +
                ", desire=" + desire +
                ", faceScore=" + faceScore +
                '}';
    }
}
package com.design.pattern;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class VehicleExampleDesign {

    interface Size {
        int getAmount();
    }

    @Getter
    @Setter
    @Builder
    static class Small implements Size {
        int amount;

        public Small(int amount) {
            this.amount = amount;
        }

        @Override
        public int getAmount() {
            return amount;
        }
    }

    @Getter
    @Setter
    @Builder
    static class Medium implements Size {
        int amount;

        public Medium(int amount) {
            this.amount = amount;
        }

        @Override
        public int getAmount() {
            return amount;
        }
    }

    interface Model {
        int getAmount();
    }

    @Getter
    @Setter
    @Builder
    static class GasModel implements Model {
        int amount;

        public GasModel(int amount) {
            this.amount = amount;
        }

        @Override
        public int getAmount() {
            return amount;
        }
    }

    @Getter
    @Setter
    @Builder
    static class ElectricModel implements Model {
        int amount;

        public ElectricModel(int amount) {
            this.amount = amount;
        }

        @Override
        public int getAmount() {
            return amount;
        }
    }


    abstract static class Vehicle {
        int id;
        String name;
        boolean available;
        VehicleType vehicleType;
        abstract int getAmount();
    }

    enum VehicleType{
        BIKE,
        SCOOTER
    }

    @Getter
    @Setter
    @Builder
    static class Bike extends Vehicle{
        int id;
        String name;
        boolean available;
        Size size;
        String type;

        @Override
        int getAmount() {
            return size.getAmount();
        }
    }

    @Getter
    @Setter
    @Builder
    static class Scooter extends Vehicle{
        int id;
        String name;
        boolean available;
        Model model;
        void setModel(Model model){
            this.model=model;
        }
        @Override
        int getAmount() {
            return model.getAmount();
        }
    }


    public List<Vehicle> getInventory(List<VehicleReq> vehicleReqList){
        List<Vehicle> vehicleList=new ArrayList<>();
        vehicleReqList.forEach(vehicleReq->{
            if(vehicleReq.type.equals(VehicleType.BIKE)){
                Vehicle vehicle=Bike.builder()
                        .id(vehicleReq.id)
                        .name(vehicleReq.name)
                        .available(vehicleReq.available)
                        .size(vehicleReq.size)
                        .build();
                vehicleList.add(vehicle);
            }
        });
        return vehicleList;
    }



    public static void main(String[] args){
        VehicleExampleDesign vehicleExampleDesign=new VehicleExampleDesign();
        VehicleReq vehicleReq1=VehicleReq.builder()
                .id(1)
                .name("V1")
                .available(true)
                .type(VehicleType.BIKE)
                .size(new Small(10))
                .build();

        VehicleReq vehicleReq2=VehicleReq.builder()
                .id(1)
                .name("V1")
                .available(true)
                .type(VehicleType.BIKE)
                .size(new Medium(20))
                .build();
        List<VehicleReq> vehicleReqList=new ArrayList<>();
        vehicleReqList.add(vehicleReq1);
        vehicleReqList.add(vehicleReq2);
        vehicleExampleDesign.getInventory(vehicleReqList);



    }


    @Getter
    @Setter
    @Builder
    static class VehicleReq{
        int id;
        String name;
        VehicleType type;
        boolean available;
        Size size;
        Model model;
    }

}

package com.example;

class Machine {
    private String type;
    private String model;
    private Worker operator;

    public Machine(String type, String model, Worker guy) {
        this.type = type;
        this.model = model;
        this.operator = guy;
    }

    public String getMachineDetails() {
        return "Koneen tiedot: " + type + ", " + model + "\nTyöntekijän tiedot: " + operator.getWorkerName() + ", " + operator.getWorkerRole() + "\n";
    }
}

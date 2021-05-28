package Vehicle;
public interface VehicleType {
    void changeRegistrationNumber(String registrationNumber);
    void changeMark(String mark);
    void changeModel(String model);
    void changeVIN(String vin);
    void changeOwner(String nameOwner);
    void changeTypeOfDrivingForce(String typeOfDrivingForce);
    void refuel(int fuel);
    void repair();
    void service();
    void passATech();
}
//Возможности: получить или изменить различную информацию о средстве передвижения:
// регистрационный номер, марка, модель, VIN-номер, владелец, тип движущей силы;
// заправить\отремонтировать\обслужить; пройти техосмотр.
// Добавить дополнительные возможности для автомобиля, велосипеда, самоката, мотоцикла, квадроцикла.
//registration number
//make, model,
//VIN number,
//owner,
//type of driving force;
//refuel\repair\service
//pass a technical inspection
package org.knit.solutions.Task3;

public class TransportFactory {
    public static Transport createTransport(String tripType) throws IllegalArgumentException {
        switch (tripType) {
            case "business":
                return new BusinessCar();
            case "family":
                return new FamilyVan();
            case "delivery":
                return new Motorbike();
            default:
                throw new IllegalArgumentException("Неизвестный тип транспорта");
        }
    }
}

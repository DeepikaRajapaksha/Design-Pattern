// Interface Definition
interface UniversalCharger {
    void charge();
}

// Specific Device Charger Classes
class IPhoneCharger {
    void chargeWithLightning() {
        System.out.println("Charging iPhone with Lightning connector");
    }
}

class AndroidCharger {
    void chargeWithMicroUSB() {
        System.out.println("Charging Android device with micro USB connector");
    }
}

// Adapter Classes
class IPhoneToUSBAdapter implements UniversalCharger {
    private IPhoneCharger iPhoneCharger;

    IPhoneToUSBAdapter(IPhoneCharger iPhoneCharger) {
        this.iPhoneCharger = iPhoneCharger;
    }

    @Override
    public void charge() {
        iPhoneCharger.chargeWithLightning();
    }
}

class AndroidToUSBAdapter implements UniversalCharger {
    private AndroidCharger androidCharger;

    AndroidToUSBAdapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void charge() {
        androidCharger.chargeWithMicroUSB();
    }
}

// Demo Class
public class AdapterDemo {
    public static void main(String[] args) {
        IPhoneCharger iPhoneCharger = new IPhoneCharger();
        AndroidCharger androidCharger = new AndroidCharger();

        UniversalCharger iPhoneAdapter = new IPhoneToUSBAdapter(iPhoneCharger);
        UniversalCharger androidAdapter = new AndroidToUSBAdapter(androidCharger);

        System.out.println("Charging devices using the universal charger:");

        System.out.println("Charging iPhone:");
        iPhoneAdapter.charge();

        System.out.println("Charging Android device:");
        androidAdapter.charge();
    }
}

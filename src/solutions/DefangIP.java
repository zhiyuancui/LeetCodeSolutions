package solutions;

/**
 * 1108 Defanging an IP Address
 */
public class DefangIP {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","\\[\\.\\]");
    }
}

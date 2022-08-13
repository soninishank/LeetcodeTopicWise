import java.util.Objects;


public class Data {
    private int id;
    private String userId;
    private String userName;
    private Long timestamp;
    private String txnType;
    private String amount;
    private Location location;
    private String ip;

    public Data(int id, String userId, String userName, Long timestamp, String txnType, String amount, Location location, String ip) {
        this.setId(id);
        this.setUserId(userId);
        this.setUserName(userName);
        this.setTimestamp(timestamp);
        this.setTxnType(txnType);
        this.setAmount(amount);
        this.setLocation(location);
        this.setIp(ip);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return getId() == data.getId() && Objects.equals(getUserId(), data.getUserId()) && Objects.equals(getUserName(), data.getUserName()) && Objects.equals(getTimestamp(), data.getTimestamp()) && getTxnType() == data.getTxnType() && Objects.equals(getAmount(), data.getAmount()) && Objects.equals(getLocation(), data.getLocation()) && Objects.equals(getIp(), data.getIp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getUserName(), getTimestamp(), getTxnType(), getAmount(), getLocation(), getIp());
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + getId() +
                ", userId='" + getUserId() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", timestamp='" + getTimestamp() + '\'' +
                ", txnType=" + getTxnType() +
                ", amount='" + getAmount() + '\'' +
                ", location=" + getLocation() +
                ", ip='" + getIp() + '\'' +
                '}';
    }




}

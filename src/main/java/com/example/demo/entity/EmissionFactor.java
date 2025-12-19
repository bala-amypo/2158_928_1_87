@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ActivityType activityType;

    private Double factorValue;

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Double getFactorValue() {
        return factorValue;
    }
}

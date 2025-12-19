@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;
    private LocalDate activityDate;
    private Double estimatedEmission;

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}

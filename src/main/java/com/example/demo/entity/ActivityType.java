@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;
    private String unit;

    @ManyToOne
    private ActivityCategory category;

    public Long getId() { return id; }
    public void setCategory(ActivityCategory category) {
        this.category = category;
    }
}

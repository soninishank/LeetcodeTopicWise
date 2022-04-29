package LLD.Fliter.FliterCriteria;

import LLD.Fliter.Model.Laptop;

import java.util.List;

public class AndCriteria implements Criteria {

    private Criteria[] criterias;

    public AndCriteria(Criteria[] criteria) {
        this.criterias = criteria;
    }

    @Override
    public List<Laptop> meets(List<Laptop> laptops) {
        for (Criteria criteria : criterias) {
            List<Laptop> meets = criteria.meets(laptops);
        }
        return null;
    }
}

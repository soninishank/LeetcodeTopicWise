package LLD.Fliter.FliterCriteria;

import LLD.Fliter.Model.Laptop;

import java.util.List;

public interface Criteria {
    List<Laptop> meets(List<Laptop> laptops);
}

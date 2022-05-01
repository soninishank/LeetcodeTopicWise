package LLD.DesignPatterns.Fliter.FliterCriteria;

import LLD.DesignPatterns.Fliter.Model.Laptop;

import java.util.List;

public interface Criteria {
    List<Laptop> meets(List<Laptop> laptops);
}

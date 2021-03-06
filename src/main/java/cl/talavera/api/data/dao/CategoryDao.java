package cl.talavera.api.data.dao;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import cl.talavera.api.data.model.CategoryModel;
import cl.talavera.api.data.repository.CategoryRestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDao implements CategoryDaoPort {
    private final CategoryRestRepository repository;
    Logger logger = LoggerFactory.getLogger(CategoryDao.class);
    public CategoryDao(CategoryRestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getTopCategories() {
        return SubCategoriesFrom(repository.getCategories()).stream()
                .sorted(Comparator.comparingInt(Category::getRelevance).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> getGrid() {
        return SubCategoriesFrom(repository.getCategories()).stream()
                .sorted(Comparator.comparingInt(Category::getRelevance).reversed())
                .skip(5)
                .collect(Collectors.toList());
    }


    private List<Category> SubCategoriesFrom(List<CategoryModel> result) {
        List<Category> categories = new ArrayList<>();

        result.forEach(levelOne -> {
            add(categories, levelOne);
            levelOne.getSubcategories().forEach(levelTwo -> {
                add(categories, levelTwo);
                levelTwo.getSubcategories().forEach(levelThree -> {
                    add(categories, levelThree);
                    levelThree.getSubcategories().forEach(levelFour -> {
                        add(categories, levelFour);
                    });
                });
            });
        });

        return categories;
    }

    private void add(List<Category> list, CategoryModel response) {
        list.add(CategoryModel.category(response));
    }
}

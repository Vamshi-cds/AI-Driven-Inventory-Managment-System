import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Categories = () => {
    const [categories, setCategories] = useState([]);
    const [newCategory, setNewCategory] = useState('');

    useEffect(() => {
        axios.get('http://localhost:8080/api/categories')
            .then(response => setCategories(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleAddCategory = () => {
        axios.post('http://localhost:8080/api/categories', { name: newCategory })
            .then(response => {
                setCategories([...categories, response.data]);
                setNewCategory('');
            })
            .catch(error => console.error(error));
    };

    return (
        <div>
            <h2>Categories</h2>
            <div className="mb-3">
                <input
                    type="text"
                    className="form-control"
                    placeholder="New Category"
                    value={newCategory}
                    onChange={(e) => setNewCategory(e.target.value)}
                />
                <button className="btn btn-primary mt-2" onClick={handleAddCategory}>
                    Add Category
                </button>
            </div>
            <ul className="list-group">
                {categories.map(category => (
                    <li key={category.id} className="list-group-item">
                        {category.name}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Categories;
import React from 'react';
import ReactDOM from 'react-dom';

function FavoriteFood() {
    return (
        <div>
            <h1>Моя любимая еда:</h1>
            <ul>
                <li>Бекон</li>
                <li>Яйца</li>
                <li>Помидоры</li>
            </ul>
        </div>
    );
}

ReactDOM.render(<FavoriteFood />, document.getElementById('root'));
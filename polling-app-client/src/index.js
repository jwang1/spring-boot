import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './app/App';
import registerServiceWorker from './registerServiceWorker';
import { BrowserRouter as Router } from 'react-router-dom';

// Note the , after Router closing tag; otherwise, raising errors:
ReactDOM.render(
    <Router>
        <App/>
    </Router>,

    document.getElementById('root')
);

registerServiceWorker();

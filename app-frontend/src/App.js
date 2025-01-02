import React from 'react';
import { BrowserRouter as Router, Route, Redirect, Routes } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Home from './Pages/Home';
import AnimalChat from './Pages/AnimalChat';

function App() {
  return (
    // <div className="App">
    //   <Switch>
    //     <Routes>
    //       <Route exact path="/home" componemt={Home}></Route>
    //       <Route exact path="/chat" componemt={AnimalChat}></Route>
    //     </Routes>
    //   </Switch>
    //   <h1>Olá ta certo</h1>
    // </div>
    // <div>
    //     <Home />
    // </div>
  <Router>
    <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/chat" element={<AnimalChat />} />
    </Routes>
  </Router>
  );
  // return (
  //   <div className="App">
  //     <header className="App-header">
  //       <img src={logo} className="App-logo" alt="logo" />
  //       <p>
  //         Edit <code>src/App.js</code> and save to reload.
  //       </p>
  //       <a
  //         className="App-link"
  //         href="https://reactjs.org"
  //         target="_blank"
  //         rel="noopener noreferrer"
  //       >
  //         Learn React
  //       </a>
  //     </header>
  //   </div>
  // );
}

export default App;

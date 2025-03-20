import './App.css';
import LoginHome from './Component/LoginHome/LoginHome';
import LayOut from './Component/MainPage/LayOut';
import NavBar from './Component/NavBar/NavBar';

function App() {
  return (
    <div className="App">
      {
        localStorage.getItem("user") == undefined ? <LoginHome/> : <span><NavBar/> <LayOut/></span>
      }
    </div>
  );
}

export default App;

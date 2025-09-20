import './App.css';
import NavBar from './Components/NavBar/NavBar';
import Layout from './Components/NavBar/MainPage/Layout';
import LoginHome from './Components/LoginHome/LoginHome';

function App() {
  return (
    <div className="App">
        {
          localStorage.getItem("user")==undefined ? <LoginHome/> : <span><NavBar /><Layout/></span>
        }
    </div>
  );
}

export default App;

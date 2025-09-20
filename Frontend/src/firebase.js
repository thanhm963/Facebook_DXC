// Import the functions you need from the SDKs you need
import { initializeApp } from 'firebase/app';
import { getStorage } from "firebase/storage";
// import { getFirestore } from "firebase/firestore";
// import { getAnalytics } from "firebase/analytics";

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyAf4bjSC2irgH7YgKbY1MYJfVEkkrwgp1U",
  authDomain: "facebook-clone-1e143.firebaseapp.com",
  projectId: "facebook-clone-1e143",
  storageBucket: "facebook-clone-1e143.appspot.com",
  messagingSenderId: "362604765198",
  appId: "1:362604765198:web:927078bac002f466a45c5f",
  measurementId: "G-KR2GHJ80Q1"
};

const app = initializeApp(firebaseConfig);
const storage = getStorage(app);

export { app, storage };



// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyAfAbjSC2irgH7YgKbY1MYJfVEkkrwgp1U",
  authDomain: "facebook-clone-1e143.firebaseapp.com",
  projectId: "facebook-clone-1e143",
  storageBucket: "facebook-clone-1e143.appspot.com",
  messagingSenderId: "362604765198",
  appId: "1:362604765198:web:927078bac002f466a45c5f",
  measurementId: "G-KR2GHJ80Q1"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

// Optionally initialize services
const auth = getAuth(app);
const db = getFirestore(app);

export { app, auth, db };

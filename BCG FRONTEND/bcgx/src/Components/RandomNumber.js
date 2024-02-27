import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function RandomNumber() {
  const [randomNumber, setRandomNumber] = useState(0);
  const [userName, setUserName] = useState('');
  const [userPrediction, setUserPrediction] = useState('');
  const [predictionResult, setPredictionResult] = useState('');
  const [incorrectPredictionCount, setIncorrectPredictionCount] = useState(0);

  useEffect(() => {
    // Fetch random number when the component mounts
    fetchRandomNumber();
  }, []);

  const fetchRandomNumber = async () => {
    try {
      const response = await axios.get('http://localhost:8085/number/random');
      setRandomNumber(response.data);
      console.log('The Random Number Generated By The Back End is:' + response.data);
    } catch (error) {
      console.error('Error fetching random number:', error);
    }
  };

  const checkPrediction = () => {
    const userPredictionNumber = Number(userPrediction);
  
    if (userPredictionNumber === randomNumber) {
      // User prediction is correct, make a POST request
      submitPrediction();
      setPredictionResult('Yippee!');
    } else {
      // Incorrect prediction, check if higher or lower
      const isHigher = userPredictionNumber > randomNumber;
      setIncorrectPredictionCount(incorrectPredictionCount + 1);
      setPredictionResult(isHigher ? 'Predicted Higher' : 'Predicted Lower');
    }
  };
  
  

  const submitPrediction = async () => {
    try {
      await axios.post('http://localhost:8085/client/predicted', {
        fullName: userName,
        numberOfTries: incorrectPredictionCount + 1, // Increment the count for correct prediction
        randomNumber: {
          number: userPrediction,
        },
      });
      setIncorrectPredictionCount(0);
      setUserPrediction('');
      fetchRandomNumber();
      setTimeout(() => {
        setPredictionResult('');
      }, 1500);
    } catch (error) {
      console.error('Error submitting prediction:', error);
    }
  };

  return (
    <div className='container'>
      <h1 className='title'>RANDOM NUMBER GENERATOR CHECK</h1>

      <p>Incorrect Predictions: {incorrectPredictionCount}</p>

      <input
        className='input'
        placeholder='Enter your name'
        onChange={(e) => {
          setUserName(e.target.value);
        }}
      />

      <input
        className='input'
        placeholder='Make a prediction'
        onChange={(e) => {
          setUserPrediction(e.target.value);
        }}
        value={userPrediction}
      />

      <button className='button' onClick={checkPrediction}>
        SUBMIT
      </button>

      <p className='fade-out'>{predictionResult}</p>
    </div>
  );
}

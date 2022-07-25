import { useState } from "react";
import { useRouter } from "next/router";
import React from "react";
import styles from "../../../styles/module.css"

const AddDog = () => {
  const [dogName, setDogName] = useState("");
  const [age, setAge] = useState("");
  const [breed, setBreed] = useState("");

  const router = useRouter();

  async function postData(url, data) {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
    router.push('./list')
    return await response.status;
  }

  const handleSubmit = (name, age, breed) => {
    var newDog = {
      dogName: name,
      age: age,
      breed: breed,
    };
    console.log("New Dog: " + JSON.stringify(newDog));

    postData("http://localhost:8080/api/v1/", newDog);
  };

  return (
    <div>
      <h1>Add new Dog</h1>
      <div className="flex align-center">
        <p>Name: </p>
        <input
    className="input"
    type="text"
    value={dogName}
    onChange={(e) => setDogName(e.target.value)}
    />
      </div>
      <div className="flex align-center">
        <p>Breed: </p>
        <input
    className="input"
    type="text"
    value={breed}
    onChange={(e) => setBreed(e.target.value)}
    />
      </div>
      <div className="flex align-center">
        <p>Age: </p>
        <input
    className="input"
    type="text"
    value={age}
    onChange={(e) => setAge(e.target.value)}
    />
      </div>
      <button onClick={() => handleSubmit(dogName, age, breed)} className={styles.btn}>Submit</button>
    </div>
  );
};

export default AddDog;

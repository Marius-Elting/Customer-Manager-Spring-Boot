import { FC, ReactElement } from "react";
import "./App.css";
import Header from "./components/Header";

const App: FC = (): ReactElement => {
  return (
    <>
      <Header />
      <p>hello</p>
    </>
  );
};

export default App;

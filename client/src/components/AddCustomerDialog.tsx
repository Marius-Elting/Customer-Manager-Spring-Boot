import { ChangeEvent, FC, FormEvent, ReactElement, useRef } from "react";

interface DialogProps {
  closeDialog: () => void;
}

const AddCustomerDialog: FC<DialogProps> = ({ closeDialog }): ReactElement => {
  const nameRef = useRef<HTMLInputElement>(null);
  const emailRef = useRef<HTMLInputElement>(null);
  const ageRef = useRef<HTMLInputElement>(null);

  const submitData = (event: ChangeEvent<HTMLFormElement>) => {
    event.preventDefault();
    const userData = {
      name: nameRef.current?.value,
      email: emailRef.current?.value,
      age: ageRef.current?.value,
    };
    fetch("http://localhost:9898/api/v1/customers", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userData),
    });
  };

  return (
    <section>
      <article className="flex flex-row justify-between p-2 gap-7">
        <h2 className="text-xl">Add new Customer</h2>
        <button onClick={() => closeDialog()}>Close</button>
      </article>
      <form
        onSubmit={submitData}
        className="flex flex-col justify-between p-2">
        <label
          className="pt-3"
          htmlFor="NameInput">
          Name
        </label>
        <input
          id="NameInput"
          placeholder="Customer Name"
          ref={nameRef}
        />
        <label
          htmlFor="EmailInput"
          className="pt-3">
          E-Mail
        </label>
        <input
          id="EmailInput"
          placeholder="Customer E-Mail"
          ref={emailRef}
        />
        <label
          htmlFor="AgeInput"
          className="pt-3">
          Age
        </label>
        <input
          id="AgeInput"
          placeholder="Customer Age"
          ref={ageRef}
        />
        <button
          className="bg-sky-500/100 p-1 m-3 text-white rounded-sm"
          type="submit">
          Submit
        </button>
      </form>
    </section>
  );
};

export default AddCustomerDialog;

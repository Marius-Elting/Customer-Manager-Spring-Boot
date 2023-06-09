import { FC, ReactElement, useRef } from "react";
import AddCustomerDialog from "./AddCustomerDialog";

const Header: FC = (): ReactElement => {
  const dialogRef = useRef<HTMLDialogElement>(null);

  const openDialog = () => {
    dialogRef.current?.showModal();
  };
  const closeDialog = () => {
    dialogRef.current?.close();
  };
  return (
    <header className="w-screen h-7">
      <section className="flex flex-row justify-around ">
        <h1 className="font-mono text-3xl">Customer Manager</h1>
        <dialog ref={dialogRef}>
          <AddCustomerDialog closeDialog={closeDialog} />
        </dialog>

        <button
          className="bg-sky-500/100 p-2 m-3 text-white rounded-sm"
          onClick={openDialog}>
          AddCustomer
        </button>
      </section>
    </header>
  );
};

export default Header;

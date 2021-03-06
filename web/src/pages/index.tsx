import type { NextPage } from "next";
import Head from "next/head";
import { useRef } from "react";
import { Footer } from "../components/Footer";
import { useGetAllFiles } from "../service/file-service";
import { useUploadFile } from "../service/upload-service";

const Home: NextPage = () => {
  const tilt = false;
  const content = useRef();

  const { mutate } = useUploadFile();
  const { data } = useGetAllFiles();

  return (
    <div tw="dark:bg-mono-900 bg-blue-500 dark:text-white">
      <Head>
        <title>PDF Watermarking Tool</title>
        <meta name="description" content="Generated by create next app" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <header
        tw="flex min-h-screen flex-col items-center justify-center gap-8 shadow-inner"
        style={{
          boxShadow: "inset 0 0 80px var(--tw-shadow-color)",
          ...(tilt
            ? {
                perspective: "50vw",
                perspectiveOrigin: "50% 50%",
                transformStyle: "preserve-3d",
              }
            : null),
        }}
      >
        <h1
          tw="dark:text-secondary-50 text-center text-6xl font-bold text-white"
          style={tilt ? { transform: "rotateX(35deg)" } : undefined}
        >
          PDF Watermarking Tool
        </h1>
        <div tw="flex gap-4">
          <a
            tw="bg-secondary-100 text-secondary-700 rounded-full px-6 py-3 text-lg font-bold shadow-2xl hover:cursor-pointer"
            href="#content"
            onClick={(e) => {
              e.preventDefault();
              content.current?.scrollIntoView({ behavior: "smooth" });
            }}
          >
            View Files
          </a>
          <button tw="bg-secondary-100 text-secondary-700 rounded-full px-6 py-3 text-lg font-bold shadow-2xl hover:cursor-pointer">
            Upload File
          </button>
        </div>
      </header>
      <main
        tw="bg-mono-50 dark:bg-mono-800 flex items-start justify-center"
        ref={content}
      >
        <div tw="grid max-w-4xl gap-8 p-8 sm:grid-cols-2 md:grid-cols-3">
          {data?.map((f, index) => (
            <div key={index}>{f}</div>
          ))}
        </div>
      </main>

      <Footer />
    </div>
  );
};

export default Home;
